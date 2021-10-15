import React, { Component } from "react";
import { products } from "../DummyData/categories.js";
import Product from "../components/Product";

class Category extends Component {
  renderProductsFromCategory(name) {
    return products
      .filter((prod) => prod.category === name)
      .map((prod, i) => {
        return <Product key={i} product={prod} />;
      });
  }

  render() {
    const name = this.props.match.params.name;

    return <div className="row">{this.renderProductsFromCategory(name)}</div>;
  }
}

export default Category;
