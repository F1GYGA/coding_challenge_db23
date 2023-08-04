import React, { useState } from 'react'
import BondsDetail from './BondsDetail'
import { useEffect } from 'react';
import { getAllBonds } from '../services/bond-service';

//const bonds = []

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