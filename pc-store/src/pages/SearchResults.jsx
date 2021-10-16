import React, { Component } from "react";
import { products } from "../DummyData/categories.js";
import Product from "../components/Product";

class SearchResults extends Component {
  checkIfProductNameIsEqualTo(prodName, searchName) {
    searchName = searchName.toLowerCase().split("%");
    prodName = prodName.toLowerCase();

    for (var i = 0; i < searchName.length; i++) {
      if (!prodName.includes(searchName[i])) return false;
    }

    return true;
  }

  renderProductsFromSearch(searchParam) {
    products.forEach((prod) => {
      this.checkIfProductNameIsEqualTo(prod.name, searchParam);
    });

    return products
      .filter((prod) =>
        this.checkIfProductNameIsEqualTo(prod.name, searchParam)
      )
      .map((prod, i) => {
        return <Product key={i} product={prod} />;
      });
  }

  render() {
    const searchParam = this.props.match.params.searchParam;

    return (
      <div className="row">{this.renderProductsFromSearch(searchParam)}</div>
    );
  }
}

export default SearchResults;
