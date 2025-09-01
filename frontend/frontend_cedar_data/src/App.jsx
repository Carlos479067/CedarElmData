import './App.css'
import Header from "./components/Header.jsx";
import Navbar from "./components/Navbar.jsx";
import Footer from "./components/Footer.jsx";
import Home from "./pages/Home.jsx";
import {useState} from "react";

function App() {

    const [searchResults, setSearchResults] = useState("");

    function updateState(data) {
        setSearchResults(data);
    }

  return (
    <>
      <Header/>
      <Navbar/>
        <Home searchResults={searchResults}/>
        <Footer/>
    </>
  )
}

export default App
