FROM node:10.13.0-alpine as bundle

ENV NODE_ENV=production

WORKDIR /tmp/build

COPY package.json .
RUN npm install

COPY src src
COPY public public

RUN npm run build

FROM debian:stretch-slim as run

RUN apt-get update && apt-get install -y --no-install-recommends \
    apache2 \
    && rm -rf /var/lib/apt/lists/*

ENV APACHE_RUN_USER=www-data APACHE_RUN_GROUP=www-data
ENV APACHE_LOG_DIR /var/log/apache2

COPY apache.conf /etc/apache2/sites-available/
COPY site-directives.conf /etc/apache2/

RUN a2dissite 000-default.conf && \
	a2disconf serve-cgi-bin.conf && \
	a2enmod proxy && \
	a2enmod proxy_http && \
	a2enmod ssl

RUN a2ensite apache.conf

COPY --from=bundle /tmp/build/build /var/www/app/

EXPOSE 80

CMD ["/usr/sbin/apache2ctl", "-D", "FOREGROUND"]
