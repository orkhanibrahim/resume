from flask import Flask, request, jsonify, render_template, make_response
import pdfkit

app = Flask(__name__)

# Simple in-memory storage for resumes
resumes = {}

@app.route('/resumes', methods=['POST'])
def create_resume():
    data = request.get_json()
    if not data or 'id' not in data:
        return jsonify({'error': 'Resume must include an id'}), 400
    resume_id = data['id']
    resumes[resume_id] = data
    return jsonify({'message': 'Resume stored', 'id': resume_id}), 201

@app.route('/resumes/<resume_id>', methods=['GET'])
def get_resume(resume_id):
    resume = resumes.get(resume_id)
    if not resume:
        return jsonify({'error': 'Resume not found'}), 404
    return jsonify(resume)

@app.route('/resumes/<resume_id>/html', methods=['GET'])
def get_resume_html(resume_id):
    resume = resumes.get(resume_id)
    if not resume:
        return jsonify({'error': 'Resume not found'}), 404
    html = render_template('resume.html', resume=resume)
    return html

@app.route('/resumes/<resume_id>/pdf', methods=['GET'])
def get_resume_pdf(resume_id):
    resume = resumes.get(resume_id)
    if not resume:
        return jsonify({'error': 'Resume not found'}), 404
    html = render_template('resume.html', resume=resume)
    # pdfkit requires wkhtmltopdf installed in the environment
    pdf = pdfkit.from_string(html, False)
    response = make_response(pdf)
    response.headers['Content-Type'] = 'application/pdf'
    response.headers['Content-Disposition'] = f'attachment; filename={resume_id}.pdf'
    return response

if __name__ == '__main__':
    app.run(debug=True)
