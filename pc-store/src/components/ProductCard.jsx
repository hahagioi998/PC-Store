import React, { Component } from "react";
import { Card } from "react-bootstrap";

import "./ProductCard.css";

class Product extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cardHover: "",
      titleHover: "",
      isHovered: false,
      availableColor:
        this.props.product.quantity > 0
          ? "availability-green"
          : "availability-red",
      availableSign: this.props.product.quantity > 0 ? "✓" : "✕",
      price: this.calculatePrice(this.props.product),
      discount: this.props.product.discountInPercent,
    };
    console.log(this.state.isDiscounted);
  }

  componentDidUpdate(prevProps) {
    if (this.props.product.id !== prevProps.product.id) {
      this.setState({
        availableColor:
          this.props.product.quantity > 0
            ? "availability-green"
            : "availability-red",
        availableSign: this.props.product.quantity > 0 ? "✓" : "✕",
        price: this.calculatePrice(this.props.product),
        discount: this.props.product.discountInPercent,
      });
    }
  }

  calculatePrice(product) {
    if (this.props.product.discountInPercent > 0) {
      return (
        product.price -
        (product.price * product.discountInPercent) / 100
      ).toFixed(2);
    } else {
      return product.price;
    }
  }

  renderDiscount() {
    if (this.props.product.discountInPercent > 0) {
      return (
        <div className="discount-amount">
          {"-" + this.props.product.discountInPercent + "%"}
        </div>
      );
    }
  }

  getLinkToProduct(id) {
    return "/products/" + id;
  }

  handleTitleClick = (name) => {
    window.location.href = this.getLinkToProduct(name);
  };

  handleMouseEnterOnTitle() {
    if (!this.state.isHovered) {
      this.setState({
        cardHover: "card-hover",
        titleHover: "title-hover",
        isHovered: true,
      });
    }
  }

  handleMouseLeaveOnTitle() {
    if (this.state.isHovered) {
      this.setState({ cardHover: "", titleHover: "", isHovered: false });
    }
  }

  render() {
    return (
      <div className="col-lg-3 col-md-6 col-sm-12 mb-2 mt-2">
        <Card
          className={this.state.cardHover}
          onClick={() => this.handleTitleClick(this.props.product.id)}
          onMouseEnter={() => this.handleMouseEnterOnTitle()}
          onMouseLeave={() => this.handleMouseLeaveOnTitle()}
        >
          <Card.Header>
            <Card.Title>
              <span className={this.state.titleHover}>
                {this.props.product.name}
              </span>
            </Card.Title>
          </Card.Header>
          <Card.Body>
            <Card.Img src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22286%22%20height%3D%22180%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20286%20180%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_17ca85fd66f%20text%20%7B%20fill%3A%23999%3Bfont-weight%3Anormal%3Bfont-family%3Avar(--bs-font-sans-serif)%2C%20monospace%3Bfont-size%3A14pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_17ca85fd66f%22%3E%3Crect%20width%3D%22286%22%20height%3D%22180%22%20fill%3D%22%23373940%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22108.5390625%22%20y%3D%2297.5%22%3E286x180%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" />
          </Card.Body>
          <Card.Body>
            <div className="available-field">
              <div className="manufacturer">
                Manufacturer: {this.props.product.manufacturer}
              </div>
              <div className={this.state.availableColor}>
                Available: {this.state.availableSign}
              </div>
            </div>
            <div className="price-field">
              {this.renderDiscount()}
              <div className="price-amount">{this.state.price} &euro;</div>
            </div>
          </Card.Body>
        </Card>
      </div>
    );
  }
}

export default Product;
