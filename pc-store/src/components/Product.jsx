import React, { Component } from "react";
import { Link } from "react-router-dom";
import { Card } from "react-bootstrap";

import "./Product.css";

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
      <div className="col-lg-3 col-md-6 col-sm-12 mb-2 mt-2">
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
      </div>
    );
  }
}

export default Product;
