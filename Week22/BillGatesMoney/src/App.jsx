import Header from "./components/Header";
import Navbar from "./components/Navbar";
import Card from "./components/Card";
import Footer from "./components/Footer";
import { ItemProvider } from "./ItemContext";

function App() {
  return (
    <ItemProvider>
      <div className="container">
        <Header />
        <Navbar />
        <Card />
        <Footer />
      </div>
    </ItemProvider>
  );
}

export default App;
