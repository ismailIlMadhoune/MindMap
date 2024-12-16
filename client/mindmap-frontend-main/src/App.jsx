import React, { useState } from 'react';
import Compiler from './components/Compiler';
import SketchPad from './components/SketchPad';
import './App.css';

const App = () => {
  const [leftWidth, setLeftWidth] = useState(50);

  const handleDrag = (e) => {
    const newWidth = (e.clientX / window.innerWidth) * 100;
    if (newWidth >= 10 && newWidth <= 90) {
      setLeftWidth(newWidth);
    }
  };

  return (
    <div id="root" className="App">
      <div className="container">
        <div
          className="code-editor"
          style={{ flexBasis: `${leftWidth}%`, maxWidth: `${leftWidth}%` }}
        >
          <Compiler />
        </div>

        <div
          className="resizer"
          onMouseDown={(e) => {
            document.addEventListener('mousemove', handleDrag);
            document.addEventListener('mouseup', () => {
              document.removeEventListener('mousemove', handleDrag);
            });
          }}
        />

        <div
          className="sketch-area"
          style={{ flexBasis: `${100 - leftWidth}%`, maxWidth: `${100 - leftWidth}%` }}
        >
          <SketchPad />
        </div>
      </div>
    </div>
  );
};

export default App;