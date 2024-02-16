import React from 'react'

const Footer = () => {
  return (
    <footer>
    <div className="footer-section center">
      <div className="footer-logo">
        <img src="src/assets/logo.png" alt="Powerfull Logo" />
      </div>
      <div className="footer-text">
        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Dicta iste excepturi, debitis similique sint
          adipisci, asperiores voluptates totam quia dolore quasi esse sed iusto, distinctio modi dignissimos repellat!
          Quisquam, accusamus!</p>
      </div>
      <div className="footer-sub-section">
        <div className="footer-info">
          <h2>Information</h2>
          <ul>
            <li><a href="#">About Us</a></li>
            <li><a href="#classes">Classes</a></li>
            <li><a href="">Blog</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div>
        <div className="footer-help">
          <h2>Helpful Links</h2>
          <ul>
            <li><a href="">Services</a></li>
            <li><a href="">Supports</a></li>
            <li><a href="">Terms & Condition</a></li>
            <li><a href="">Privacy Policy</a></li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
  )
}

export default Footer