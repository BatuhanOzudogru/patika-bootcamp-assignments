// StatisticsContainer.js
import React from 'react';

const Stat = () => {
  return (
    <section className="statistics-container center">
      <article className="statistic-card">
        <div className="statistic-info">
          <p className="statistic-value">325</p>
          <p>Courses</p>
        </div>
        <div className="statistic-info">
          <p className="statistic-value">405</p>
          <p>Work Outs</p>
        </div>
        <div className="statistic-info">
          <p className="statistic-value">305</p>
          <p>Working Hours</p>
        </div>
        <div className="statistic-info">
          <p className="statistic-value">705</p>
          <p>Happy Clients</p>
        </div>
      </article>
    </section>
  );
};

export default Stat;
