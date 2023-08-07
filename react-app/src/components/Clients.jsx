import React, { useState } from 'react'
import BondsDetail from './BondsDetail'
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
                <Panel header={client.holderName + " Bonds: " + client.bonds.length + " Position: " + client.position} key={client.id}>
                    <BondsDetail info={client.bonds} />
                </Panel>
            ))}
        </Collapse>
    )
}


export default Clients;