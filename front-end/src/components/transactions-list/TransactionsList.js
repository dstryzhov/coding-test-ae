import React from 'react';
import Accordion from 'react-bootstrap/Accordion';
import Transaction from '../transaction/Transaction';
import TransService from '../../service/TransactionService';

class TransactionList extends React.Component {
    state = {
        transactions: []
    };


    componentWillMount() {
        TransService.getTransactions()
            .then(value => {
                this.setState({transactions: value});
            });
    }

    render() {
        return (
            <Accordion>
                {this.state.transactions.map((transaction, key) =>
                    <Transaction {...transaction} key={key} index={key + 1}/>)}
            </Accordion>
        );
    }
}

export default TransactionList;
