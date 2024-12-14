// CodeEditor.jsx
import React from 'react';
import MonacoEditor from '@monaco-editor/react';

const CodeEditor = ({ code, setCode, language }) => {
  const handleEditorChange = (value) => {
    setCode(value);
  };

  // Map compiler language options to Monaco editor language identifiers
  const getMonacoLanguage = (compilerLang) => {
    const languageMap = {
      'java': 'java',
      'python': 'python',
      'c': 'c',
      'cpp': 'cpp'
    };
    return languageMap[compilerLang] || 'plaintext';
  };

  return (
    <div style={{ height: '80%', border: '1px solid #ddd' }}>
      <MonacoEditor
        height="100%"
        language={getMonacoLanguage(language)} // Use language prop instead of defaultLanguage
        value={code}
        onChange={handleEditorChange}
        theme="vs-dark"
        options={{
          fontSize: 14,
          minimap: { enabled: false },
          automaticLayout: true, // Enable automatic layout adjustments
          scrollBeyondLastLine: false,
          wordWrap: 'on',
          formatOnPaste: true,
          formatOnType: true
        }}
      />
    </div>
  );
};

export default CodeEditor;