import http from './axios-common';
import axios from 'axios';


export async function getAllBonds(){
    return await axios.get('http://127.0.0.1:8080/bonds', {
        withCredentials: true,
    });
}

export function getBooks(){
    return http.get("/books");
}

export function getCounterParties(){
    return http.get("/counterparties");
}

export function getTrades(){
    return http.get("/trades");
}