import React, { Component } from "react";

import { Link } from "react-router-dom";
import { FormControl } from "react-bootstrap";

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
      <div id="jumbotron">
        <h1 className="display-3">Welcome to AnzurakiZz PC Shop</h1>
        <p className="lead">
          The pc shop with the latest and greatest pc components, and reasonable
          prices.
        </p>
        <div id="intro-search" className="col-lg-5 col-md-10 col-sm-8 d-flex">
          <FormControl
            type="text"
            placeholder="Search"
            className="mr-2"
            aria-label="Search"
            onChange={(evt) => this.updateSearchLink(evt)}
            onKeyPress={this.handleKeyPress}
          />
          <Link to={this.state.searchLink} className="btn btn-primary">
            Search
          </Link>
        </div>
      </div>
    );
  }
}

export default Intro;
