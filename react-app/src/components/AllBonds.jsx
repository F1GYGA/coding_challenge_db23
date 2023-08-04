import React, { useState } from 'react'
import BondsDetail from './BondsDetail'
import { useEffect } from 'react';
import { getAllBonds } from '../services/service';

const bonds = []

const trades = [
  {
    'id':1,'book_id':1, 'security_id':'A12356111','counterparty_id':1,'trade_type':'buy','quantity':50,'trade_currency':'USD','trade_status':'open',
    'unit_price':300,'trade_date':'2021-08-02','trade_settlement_date':'2021-08-03'
  }
]

const counter_parties = [
  {
    'id': 1, 'holder_name':'AZ Holdings Inc'
  }
]



//inbetween is the temporary code to combine tables and test the ui, should not be used once the backend is functioning

const map = new Map();
bonds.forEach(item => map.set(item.isin, item));
trades.forEach(item => map.set(item.security_id, {...map.get(item.security_id), ...item}));
const mergedArr = Array.from(map.values());

const map2 = new Map();
mergedArr.forEach(item => map2.set(item.counterparty_id, item));
counter_parties.forEach(item => map2.set(item.id, {...map2.get(item.id), ...item}));
const mergedArr2 = Array.from(map2.values());


console.log(JSON.stringify(mergedArr2));

//inbetween is the temporary code to combine tables and test the ui, should not be used once the backend is functioning

const AllBonds = () => {
  const [bonds, setBonds] = useState([]);
  
  useEffect(() => {
    getBondsFromAPI();
  },[]);

  const getBondsFromAPI = () => {
    getAllBonds()
      .then(res => {
        setBonds(res.data);
      })
      .catch(err => {
        setBonds([]);
        console.log(err);
      })
  }




  return (
    <BondsDetail info={bonds} />
    //<BondsDetail info={mergedArr2} />
  )
}


export default AllBonds;