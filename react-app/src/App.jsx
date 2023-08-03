import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import AllBonds from "./components/AllBonds";
import SignIn from './components/SignIn';
import { Router, Route, Routes, Navigate } from 'react-router';



const App = () => {

  return (
    <Router>
      <Routes>
        <Route exact path="/login" component={SignIn}></Route>
        <Route exact path="/main" component={AllBonds}></Route>
        <Navigate to="/login" />
      </Routes>
    </Router>

  )


};

export default App;