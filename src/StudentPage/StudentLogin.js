import React, { useState } from 'react';

const Navbar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleNavbar = () => {
    setIsOpen(!isOpen);
  };

  return (
    <nav className="navbar">
      <div className="navbar-brand">Logo</div>
      <button className="navbar-toggle" onClick={toggleNavbar}>
        Menu
      </button>
      <ul className={`navbar-menu ${isOpen ? 'open' : ''}`}>
        <li className="navbar-item">Home</li>
        <li className="navbar-item">About</li>
        <li className="navbar-item">Services</li>
        <li className="navbar-item">Contact</li>
      </ul>
    </nav>
  );
};

export default Navbar;
