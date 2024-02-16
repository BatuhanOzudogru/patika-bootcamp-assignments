import React from "react";
import { useContext } from "react";
import { PurchaseContext } from "../../contexts/PurchaseContext";

const Purchase = () => {
  const { products, setProducts } = useContext(PurchaseContext);

  return (
    <div className="purchase-section center">
      <div className="purchase-intro">
        <h2>PURCHASE FROM US</h2>
        <p></p>
        <p className="explanation">
          Lorem Ipsum is not simply random text. It has roots in a piece of
          classical at Hampden-Sydney College.
        </p>
      </div>
      <div className="purchase-cards">
        {products.map((product) => (
          <div className="purchase-card" key={product.id}>
            <div className="purchase-card-info">
              <img src={product.img} alt="" />
              <h3>{product.name}</h3>
              <p>
                <span style={{ textDecoration: "line-through" }}>
                  {product.price}$
                </span>
                / {product.discountPrice}$
              </p>
              <div className="add-to-cart">
                <span className="add-to-cart-figure">
                  <i className="fa-solid fa-cart-shopping"></i>
                </span>
                <p>Add To Cart</p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Purchase;
