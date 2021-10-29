import React, { Component } from "react";
import { Link } from "react-router-dom";
import { Card } from "react-bootstrap";

import "./Categories.css";

class Categories extends Component {
  constructor(props) {
    super(props);
    this.state = {
      categories: [],
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/api/categories")
      .then((data) => data.json())
      .then((json) => {
        this.setState({
          categories: json,
        });
      })
      .catch(function (ex) {
        console.log("Error:", ex);
      });
  }

  categoriesList() {
    return this.state.categories.map((category, i) => (
      <div key={i} className="category-link">
        <Link
          to={"/category/" + category.id}
          key={i}
          className="btn btn-primary category-link-button"
        >
          {category.name}
        </Link>
      </div>
    ));
  }

  render() {
    return <Card id="category-link-container">{this.categoriesList()}</Card>;
  }
}

export default Categories;
