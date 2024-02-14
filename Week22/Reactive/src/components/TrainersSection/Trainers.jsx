import React from "react";
import { useContext, useState } from "react";
import { TrainerContext } from "../../contexts/TrainerContext";

const Trainers = () => {
  const { trainers, setTrainers } = useContext(TrainerContext);

  return (
    <div id="trainer" className="trainers-section center">
      <div className="trainers-intro">
        <h2>OUR BEST TRAINERS</h2>
        <p></p>
        <p className="explanation">
          Lorem Ipsum is not simply random text. It has roots in a piece of
          classical at Hampden-Sydney College.
        </p>
      </div>

      <div className="trainers-cards">
        {trainers.map((trainer) => (
        <div className="trainers-card" key={trainer.id}>
          <img src={trainer.img} alt="" />
          <div className="trainers-yAxis-frame"></div>
          <div className="trainers-xAxis-frame"></div>
          <div className="trainers-name">
            <h2>{trainer.name}</h2>
            <p>{trainer.department}</p>
          </div>
        </div>
         ))};
      </div>
    </div>
  );
};

export default Trainers;
