import React, { Component } from "react";
import { categories } from "../DummyData/categories.js";
import { Link } from "react-router-dom";

class Categories extends Component {
  categoriesList() {
    return (
      <ul>
        {categories.map((category, i) => (
          <Link to={"/category/" + category.route} key={i} className="row">
            {category.name}
          </Link>
        ))}
      </ul>
    );
  }

  render() {
    return <React.Fragment>{this.categoriesList()}</React.Fragment>;
  }
}

export default Categories;
