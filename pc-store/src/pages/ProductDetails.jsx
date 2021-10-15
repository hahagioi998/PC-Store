import React, { Component } from "react";
import { products } from "../DummyData/categories.js";

class ProductDetails extends Component {
  renderProductPage(name) {
    const product = products.find((product) => product.route === name);
    return (
      <React.Fragment>
        <h1>{product.name}</h1>
        <h3>{product.description}</h3>
      </React.Fragment>
    );
  }

  render() {
    const name = this.props.match.params.name;

    return <div className="border">{this.renderProductPage(name)}</div>;
  }
}

export default ProductDetails;
