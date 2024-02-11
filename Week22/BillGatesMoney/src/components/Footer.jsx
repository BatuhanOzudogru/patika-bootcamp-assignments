import { useContext } from "react";
import { ItemContext } from "../ItemContext";

const Footer = () => {
  const { items } = useContext(ItemContext);

  const filteredItems = items.filter((item) => item.amount > 0);

  const totalValue = filteredItems.reduce(
    (acc, item) => acc + item.amount * item.price,
    0
  );

  if (filteredItems.length === 0) {
    return null;
  }

  return (
    <div className="spree-wrapper">
      <div className="spree-headline">Your Receipt</div>
      {filteredItems.map((item) => (
        <div key={item.id} className="spree-items">
          <div className="spree-item-name">{item.name}</div>
          <div className="spree-item-amount">x{item.amount}</div>
          <div className="spree-item-cost">
            {currencyFormat(item.amount * item.price)}
          </div>
        </div>
      ))}
      <div className="spree-total">
        <span>TOTAL</span>
        <div className="spree-total-money">
          ${totalValue.toLocaleString("en-US")}
        </div>
      </div>
    </div>
  );

  function currencyFormat(cost) {
    var res;

    switch (true) {
      case cost >= 1e9:
        res = "$" + (cost / 1e9).toFixed(1) + "B";
        break;
      case cost >= 1e6:
        res = "$" + (cost / 1e6).toFixed(1) + "M";
        break;
      case cost >= 1e3:
        res = "$" + (cost / 1e3).toFixed(1) + "k";
        break;
      default:
        res = "$" + cost.toLocaleString("en-US");
    }

    return res;
  }
};

export default Footer;
