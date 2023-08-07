import React, { useState } from 'react'
import BondsDetail from './BondsDetail'
import { useEffect } from 'react';
import { getUserBooks } from '../services/service';
import { Collapse } from 'antd';
  
const { Panel } = Collapse;

const UserBooks = () => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        getBooksFromAPI();
    }, []);

    const getBooksFromAPI = () => {
        getUserBooks()
            .then(res => {
                setBooks(res.data);
                console.log(res.data);
            })
            .catch(err => {
                setBooks([]);
                console.log(err);
            })
    }




    return (
        <Collapse>
            {books.map((book) => (
                <Panel header={book.bookName} key={book.id}>
                    <BondsDetail info={book.bonds} />
                </Panel>
            ))}
        </Collapse>
    )
}


export default UserBooks;