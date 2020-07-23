function getTransactions() {
    return fetch('http://localhost:8080/api/transactions')
        .then(value => value.json());
}

const TransService = {getTransactions};

export default TransService;
