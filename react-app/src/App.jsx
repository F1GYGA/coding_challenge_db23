import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import AllBonds from "./components/AllBonds";
import LogIn from './components/LogIn';
import { Route, Routes } from 'react-router';
import { BrowserRouter } from 'react-router-dom';


const App = () => {
  return (

    <React.StrictMode>
    <BrowserRouter>
    <Routes>
      <Route path="/login" exact element={<LogIn/>} />
      <Route path="/main" exact element={<AllBonds/>} />
      <Route path="/"  exact element={<LogIn/>} />
    </Routes>
    </BrowserRouter>
  </React.StrictMode>

  
  );
};

export default App;
