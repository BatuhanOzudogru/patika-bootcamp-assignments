import Hero from "./components/HeroSection/Hero";
import Stat from "./components/StatSection/Stat";
import Class from "./components/ClassSection/Class";
import BMI from "./components/BMISection/BMI";
import Trainers from "./components/TrainersSection/Trainers";
import Purchase from "./components/PurchaseSection/Purchase";
import Review from "./components/ReviewSection/Review";
import Contact from "./components/ContactSection/Contact";
import Footer from "./components/Footer/Footer";
import { DataProvider } from "./contexts/DataContext";
import { TrainerProvider } from "./contexts/TrainerContext";
import { PurchaseProvider } from "./contexts/PurchaseContext";
import { ReviewProvider } from "./contexts/ReviewContext";

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
      <PurchaseProvider>
        <Purchase/>
      </PurchaseProvider>
      <ReviewProvider>
        <Review/>
      </ReviewProvider>
      <Contact/>
      <Footer/>
    </>
  );
}

export default App;
