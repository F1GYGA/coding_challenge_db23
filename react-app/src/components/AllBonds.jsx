import React, { useState } from 'react'
import BondsDetail from './BondsDetail'
import { useEffect } from 'react';
import { getAllBonds } from '../services/bond-service';

// const bonds = [
//   {
//     'isin': 'A12356111', 'cusip': '123456bh0', 'currency': 'USD', 'coupon_percent': 2, 'face_value': 900, 'issuer_name': 'UBS Facebook (USD)', 'status': 'active',
//     'type': 'CORP', 'maturity': '2021-09-30'
//   },
//   {
//     'isin': 'A12356122', 'cusip': '123456xh0', 'currency': 'CNY', 'coupon_percent': 20, 'face_value': 9000, 'issuer_name': 'CS Facebook (CNY)', 'status': 'active',
//     'type': 'CORP', 'maturity': '2021-09-22'
//   }
// ]


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
  )
}


export default AllBonds;