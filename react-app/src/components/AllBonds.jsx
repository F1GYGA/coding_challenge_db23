import React, { useState } from 'react'
import BondsDetail from './BondsDetail'
import { useEffect } from 'react';
import { getAllBonds } from '../services/service';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const AllBonds = () => {
  const [bonds, setBonds] = useState([]);
  const [date, setDate] = useState(new Date());

  useEffect(() => {
    getBondsFromAPI();
  }, []);

  const getBondsFromAPI = () => {
    getAllBonds()
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
      <DatePicker selected={date} onChange={(startDate) => setDate(startDate)} />
      <BondsDetail info={bonds} date={date}/>
    </>
  )
}


export default AllBonds;