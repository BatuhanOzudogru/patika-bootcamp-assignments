import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Starship from './Pages/Starship';
import Details from './Pages/Details';


function App() {
  return (
    <Router> 
      <Routes>
        <Route path="/" element={<Starship />} />
        <Route path="/starships/:id" element={<Details />} />
      </Routes>
    </Router>
  );
}

export default App;
