function getAccount() {
    return fetch('http://localhost:8080/api/account')
        .then(value => value.json());
}

const AccountService = {getAccount};

export default AccountService;
