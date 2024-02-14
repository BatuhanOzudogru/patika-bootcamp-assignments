import React from 'react'
import NavBar from "./NavBar";
import HeroArticle from "./HeroArticle";
import '../../index.css'

const Hero = () => {
  return (
    <div className="hero-container">
        <section className="center" style={{color : 'white'}}>
        <NavBar/>
        <HeroArticle/>
        </section>
    </div>
  )
}

export default Hero