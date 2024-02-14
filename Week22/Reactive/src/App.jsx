import Hero from "./components/HeroSection/Hero";
import Stat from "./components/StatSection/Stat";
import Class from "./components/ClassSection/Class";
import BMI from "./components/BMISection/BMI";
import Trainers from "./components/TrainersSection/Trainers";
import { DataProvider } from "./contexts/DataContext";
import { TrainerProvider } from "./contexts/TrainerContext";

function App() {
  return (
    <>
      <Hero />
      <Stat />
      <DataProvider>
        <Class />
      </DataProvider>
      <BMI />
      <TrainerProvider>
        <Trainers />
      </TrainerProvider>
    </>
  );
}

export default App;
