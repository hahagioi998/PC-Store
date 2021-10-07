import React, { Component } from "react";
import { categories } from "../DummyData/categories.js";

class Categories extends Component {
  categoriesList() {
    return (
      <ul>
        {categories.map((category) => (
          <li key={category.id}>{category.name}</li>
        ))}
      </ul>
    );
  }

  render() {
    return <React.Fragment>{this.categoriesList()}</React.Fragment>;
  }
}

export default Categories;
