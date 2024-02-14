// Navigation.js
import React from 'react';


const NavBar = () => {
  return (
    <nav>
      <div className="logo">
        <img src="src/assets/logo.png" alt="Powerfull Logo" />
      </div>
      <div className="link">
        <ul>
          <li><a href="#">Home</a></li>
          <li><a href="#classes">Classes</a></li>
          <li><a href="#trainer">Trainer</a></li>
          <li><a href="#review">Review</a></li>
          <li><a href="#contact">Contact</a></li>
          <li><a href="#" className="nav-btn">JOIN US</a></li>
        </ul>
      </div>
      <input type="checkbox" id="check" />
      <label htmlFor="check" className="checkbtn">
        <i className="fas fa-bars"></i>
      </label>
    </nav>
  );
};

export default NavBar;
