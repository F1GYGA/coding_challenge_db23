import React, { useState } from 'react'
import TradesCollapsableTable from './TradesCollapseTable'
import { useEffect } from 'react';
import { getCounterParties } from '../services/service';
import { Collapse } from 'antd';
  
const { Panel } = Collapse;

const Clients = () => {
    const [clients, setClients] = useState([]);

    useEffect(() => {
        getClientsFromAPI();
    }, []);

    const getClientsFromAPI = () => {
        getCounterParties()
            .then(res => {
                setClients(res.data);
                console.log(res.data);
            })
            .catch(err => {
                setClients([]);
                console.log(err);
            })
    }




    return (
        <Collapse>
            {clients.map((client) => (
                <Panel header={client.holderName + " Position: $" + client.position.toFixed(2)} key={client.id}>
                    <TradesCollapsableTable rows = {client.trades} counterparty={client.holderName} />
                </Panel>
            ))}
        </Collapse>
    )
}


export default Clients;