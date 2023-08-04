import React, { useState } from 'react'
import BondsDetail from './BondsDetail'
import { useEffect } from 'react';
import { getMaturingBonds } from '../services/service';

//const bonds = []

const BondsMaturity = () => {
  const [bonds, setBonds] = useState([]);
  const [date, setDate] = useState('2021-08-09');

  useEffect(() => {
    getBondsFromAPI();
  },[]);

  const getBondsFromAPI = () => {
    getMaturingBonds(date)
      .then(res => {
        setBonds(res.data);
        console.log(res.data);
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

export default BondsMaturity;
