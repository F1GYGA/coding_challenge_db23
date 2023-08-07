import http from './axios-common';
import axios from 'axios';


export async function getAllBonds(){
    return await axios.get('http://127.0.0.1:8080/bonds', {
        withCredentials: true,
    });
}

export async function getMaturingBonds(date){
    return await axios.get('http://127.0.0.1:8080/bonds/maturity?date='+date, {
        withCredentials: true,
    });
}

export async function getUserBooks(){
    return await axios.get('http://127.0.0.1:8080/books', {
        withCredentials: true,
    });
}

export function getCounterParties(){
    return http.get("/counterparties");
}

export function getTrades(){
    return http.get("/trades");
}