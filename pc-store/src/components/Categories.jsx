import React, { Component } from "react";
import { categories } from "../DummyData/categories.js";
import { Link } from "react-router-dom";
import { Card } from "react-bootstrap";

import "./Categories.css";

class Categories extends Component {
  categoriesList() {
    return categories.map((category, i) => (
      <div key={i} className="category-link">
        <Link
          to={"/category/" + category.route}
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
