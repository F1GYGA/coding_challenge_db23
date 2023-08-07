import React, { useState } from 'react'
import BondsDetail from './BondsDetail'
import { useEffect } from 'react';
import { getMaturingBonds } from '../services/service';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

//const bonds = []

const BondsMaturity = () => {
  const [bonds, setBonds] = useState([]);
  const [date, setDate] = useState(new Date());

  useEffect(() => {
    getBondsFromAPI();
    console.log(date);
    console.log(date.toISOString().slice(0,10))
  },[date]);

  const getBondsFromAPI = () => {
    getMaturingBonds(date.toISOString().slice(0,10))
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
    <>
      <DatePicker selected={date} onChange={(startDate)=>setDate(startDate)}/>
      <BondsDetail info={bonds} date={date} />
      
    </>
  )
}

export default BondsMaturity;
