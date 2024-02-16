import React, { useState, useEffect } from "react";

const BMI = () => {
  const [height, setHeight] = useState("");
  const [weight, setWeight] = useState("");
  const [dynamicLeft, setDynamicLeft] = useState("");

  useEffect(() => {
    calculateBMI();
  }, [height, weight]);

  const calculateBMI = () => {

    var bmi = (weight / ((height / 100) * (height / 100))).toFixed(1);

    if (bmi > 40) {
      bmi = 40;
    } else if (bmi < 0) {
      bmi = 0;
    }
    var left = "";
    switch (true) {
      case bmi < 18.5:
        left = bmi * (15 / 18.5) + 7;
        setDynamicLeft(left);
        console.log("calisti" + 1)
        break;
      case bmi <= 24.9:
        left = (bmi - 18.5) * (15 / 6.4) + 23.5;
        setDynamicLeft(left);
        console.log("calisti" + 2)
        break;
      case bmi <= 29.9:
        left = (bmi - 25) * (15 / 4.9) + 40;
        setDynamicLeft(left);
        console.log("calisti" + 3)
        break;
      case bmi <= 34.9:
        left = (bmi - 30) * (15 / 4.9) + 56.5;
        setDynamicLeft(left);
        console.log("calisti" + 4)
        break;
      case bmi > 34.9:
        left = (bmi - 35) * (15 / 4.9) + 73;
        setDynamicLeft(left);
        console.log("calisti" + 5)
        break;
    }
  };

  return (
    <section className="bmi-section center">
      <article className="bmi-article">
        <h2>BMI Calculator</h2>
        <p>
          Contrary to popular belief, Lorem Ipsum is not simply random text. It
          has roots in a piece of classical Latin literature from 45 BC, making
          it over 2000 years old.
          <br />
          Contrary to popular belief, Lorem Ipsum is not simply random text. It
          has roots in a piece of classical Latin literature from 45 BC, making
          it over 2000 years old.
        </p>
        <div className="bmi-calculator">
          <input
            type="number"
            name="cm"
            id="cm"
            placeholder="Your Height"
            value={height}
            onInput={(e) => {
              setHeight(e.target.value);
              calculateBMI();
              console.log("hei " + e.target.value)
            }}
            required
          />
          <label htmlFor="cm">cm</label>
          <input
            type="number"
            name="kg"
            id="kg"
            step="0.1"
            placeholder="Your Weight"
            value={weight}
            onInput={(e) => {
              setWeight(e.target.value);
              calculateBMI();
              console.log("wei " + e.target.value)
            }}
            required
          />
          <label htmlFor="kg">kg</label>
        </div>
      </article>
      <div className="bmi-figure ">
        <h3>Your BMI</h3>
        <img src="src/assets/bmi-index.jpg" alt="" />
        <div
          className="bmi-indicator"
          style={{ left: `${dynamicLeft}%` }}
        ></div>
      </div>
    </section>
  );
};

export default BMI;
