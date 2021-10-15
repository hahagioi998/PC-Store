import React, { Component } from "react";
import { Link } from "react-router-dom";
import { Card } from "react-bootstrap";

import { products } from "../DummyData/categories.js";

class Product extends Component {
  renderLinkToProduct(name) {
    return (
      <Link
        to={"/product-details/" + name}
        className="btn btn-primary category-link"
      >
        Details
      </Link>
    );
  }

  render() {
    return (
      <React.Fragment>
        <Card>
          <Card.Body>
            <Card.Title>{this.props.product.name}</Card.Title>
            <Card.Text>{this.props.product.description}</Card.Text>
          </Card.Body>
          <Card.Body>
            <Card.Text>
              {this.renderLinkToProduct(this.props.product.route)}
            </Card.Text>
          </Card.Body>
        </Card>
      </React.Fragment>
    );
  }
}

export default Product;
