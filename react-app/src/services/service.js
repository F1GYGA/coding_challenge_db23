import http from './axios-common';


export function getAllBonds(){
    return http.get("/bonds");
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