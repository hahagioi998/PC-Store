import React, { Component } from "react";

import { Jumbotron } from "react-bootstrap";
import { Form, FormControl, Button } from "react-bootstrap";
import NAME_OF_SHOP from "../global_variables";

import "./Intro.css";

class Intro extends Component {
  render() {
    return (
      <Jumbotron>
        <h1 className="display-3">Welcome to {NAME_OF_SHOP}</h1>
        <p className="lead">
          The pc shop with the latest and greatest pc components, and reasonable
          prices.
        </p>
        <hr className="my-2" />
        <Form id="intro-search" className="d-flex">
          <FormControl
            type="search"
            placeholder="Search"
            className="mr-2"
            aria-label="Search"
          />
          <Button variant="outline-secondary">Search</Button>
        </Form>
        <hr className="my-2" />
      </Jumbotron>
    );
  }
}

export default Intro;
