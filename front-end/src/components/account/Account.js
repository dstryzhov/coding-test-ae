import React from 'react';
import TransactionList from '../transactions-list/TransactionsList';
import AccountService from '../../service/AccountService';


class Account extends React.Component {
    state = {
        account: {}
    };

    componentWillMount() {
        AccountService.getAccount().then(value => {
            this.setState({account: value})
        });
    }

    render() {
        return (
            <div>
                <h1>Current balance: {this.state.account.balance}</h1>
                <h2 align="left">Transaction history</h2>
                <TransactionList/>
            </div>
        );
    }
}

export default Account;
