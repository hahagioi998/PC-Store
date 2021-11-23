import React, { Component } from "react";
import { Nav } from "react-bootstrap";
import { Navbar } from "react-bootstrap";
import { Container } from "react-bootstrap";
import { NavDropdown } from "react-bootstrap";
import { Link } from "react-router-dom";

import "./NavBar.css";

class NavBar extends Component {
  render() {
    return (
      <Navbar id="navbar" expand="lg">
        <Container>
          <Navbar.Brand>
            <Link to="/" id="nav-button" className="navbar-brand">
              AnzurakiZz PC Shop
            </Link>
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Link to="/About" id="nav-button" className="nav-link">
                About
              </Link>
              <Link to="/AddProduct" id="nav-button" className="nav-link">
                Add Product
              </Link>
              <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                <NavDropdown.Item href="#action/3.2">
                  Another action
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">
                  Something
                </NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.4">
                  Separated link
                </NavDropdown.Item>
              </NavDropdown>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    );
  }
}

export default NavBar;
