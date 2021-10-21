import React, { Component } from "react";

import { Link } from "react-router-dom";
import { Jumbotron, FormControl } from "react-bootstrap";
import NAME_OF_SHOP from "../global_variables";

import "./Intro.css";

class Intro extends Component {
  constructor(props) {
    super(props);
    this.state = {
      searchLink: "",
    };
  }

  updateSearchLink(evt) {
    this.setState({ searchLink: "/search/" + evt.target.value });
  }

  // Use arrow function, otherwise state is undefined
  handleKeyPress = (target) => {
    if (target.charCode === 13) {
      window.location.href = this.state.searchLink;
    }
  };

  render() {
    return (
      <Jumbotron>
        <hr className="my-2" />
        <h1 className="display-3">Welcome to {NAME_OF_SHOP}</h1>
        <p className="lead">
          The pc shop with the latest and greatest pc components, and reasonable
          prices.
        </p>
        <hr className="my-2" />
        <div id="intro-search" className="col-lg-5 col-md-10 col-sm-8 d-flex">
          <FormControl
            type="text"
            id="searchTextBox"
            placeholder="Search"
            className="mr-2"
            aria-label="Search"
            onChange={(evt) => this.updateSearchLink(evt)}
            onKeyPress={this.handleKeyPress}
          />
          <Link to={this.state.searchLink} className="btn btn-secondary">
            Search
          </Link>
        </div>
        <hr className="my-2" />
      </Jumbotron>
    );
  }
}

export default Intro;
