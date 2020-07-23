import React from 'react';
import Card from 'react-bootstrap/Card';
import Accordion from 'react-bootstrap/Accordion';
import Button from 'react-bootstrap/Button';
import Alert from 'react-bootstrap/Alert';
import Table from 'react-bootstrap/Table';

function Transaction(props) {
    return (
        <Card>

            <Card.Header>
                <Alert class='p-0 m-0'
                    variant={props.type === 'credit' ? 'danger' : 'success'}>
                <Accordion.Toggle
                    as={Button}
                    variant="link" eventKey={props.index}>
                        {props.amount} <sup>{props.type}</sup>
                </Accordion.Toggle>
                </Alert>
            </Card.Header>
            <Accordion.Collapse eventKey={props.index}>
                <Card.Body class='p-0'>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Type</th>
                            <th>Amount</th>
                            <th>Effective date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>{props.id}</td>
                            <td>{props.type}</td>
                            <td>{props.amount}</td>
                            <td>{props.effectiveDate}</td>
                        </tr>
                        </tbody>
                    </Table>
                </Card.Body>
            </Accordion.Collapse>

        </Card>
    );
}

export default Transaction;
