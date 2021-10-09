import React, { Component } from "react";
import { categories } from "../DummyData/categories.js";
import { Link } from "react-router-dom";

import "./Categories.css";

class Categories extends Component {
  categoriesList() {
    return (
      <ul>
        {categories.map((category, i) => (
          <div key={i}>
            <Link
              to={"/category/" + category.route}
              key={i}
              className="btn btn-primary category-link"
            >
              {category.name}
            </Link>
          </div>
        ))}
      </ul>
    );
  }

  render() {
    return <React.Fragment>{this.categoriesList()}</React.Fragment>;
  }
}

export default Categories;
