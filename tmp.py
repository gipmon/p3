from os import listdir
from os.path import isfile, join
import os

mypath = "."
extension = ".java"
line = "// Rafael Ferreira https://github.com/gipmon/p3\n"

for root, directories, filenames in os.walk('.'):
    for filename in filenames:
        if extension in filename and '.git' not in root :
            print os.path.join(root,filename)
            with file(os.path.join(root,filename), 'r') as original: data = original.read()
            with file(os.path.join(root,filename), 'w') as modified: modified.write(line + "\n" + data)
