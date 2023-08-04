import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import AllBonds from "./components/AllBonds";
import BondsMaturity from "./components/BondsMaturity";
import LogIn from './components/LogIn';
import { Route, Routes } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import Trades from './components/Trades'
import Nav from 'react-bootstrap/Nav'
import Navbar from 'react-bootstrap/Navbar'
import { Container } from 'react-bootstrap';

const App = () => {
  return (

    <>
      <Navbar expand='lg' className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Sign In</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/bonds">All Bonds</Nav.Link>
              <Nav.Link href="/bonds/maturity">Maturing Bonds</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>


      <React.StrictMode>
        <BrowserRouter>
          <Routes>
            <Route path="/login" exact element={<LogIn />} />
            <Route path="/bonds" exact element={<AllBonds />} />
            <Route path="/bonds/maturity" exact element={<BondsMaturity />} />
            <Route path="/" exact element={<LogIn />} />
            <Route path="/trades" exact element={<Trades />}></Route>
     // <Route path="/trades" exact element={<Trades />}></Route>
          </Routes>
        </BrowserRouter>
      </React.StrictMode>

    </>
  );
};

export default App;
