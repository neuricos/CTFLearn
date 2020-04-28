#!/usr/bin/env ruby

md_files = []

dirs_to_process = ["."]

while dirs_to_process.length != 0 do
  d = dirs_to_process.shift
  Dir[d + "/*"].each do |e|
    if File.file? e and File.extname(e) == ".md"
      md_files << e
    end
    if File.directory? e
      if e != "." and e != ".."
        dirs_to_process << e
      end
    end
  end
end

md_files.each do |f|
  output = system("grep", "![[]this", f)
  if output
    puts f
  end
end
